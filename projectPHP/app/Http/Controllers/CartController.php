<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Cart;
use App\Billet;

class CartController extends Controller
{
    public function index()
    {
        $reduc = session()->get('reduction')['montant'] ?? 0;
        $total = Cart::total() - $reduc;
        return view('panier', ['total' => $total]);
    }

    public function add(Request $request)
    {
        $quantite = Billet::where('id', $request->id)->first();
        /* return $quantite . '<br>' . $request->id . '<br>' . $request->typeMatch . '<br>' . $request->quantite . '<br>' . $request->prix; */
        if($quantite->quantite >= $request->quantite)
        {
            $q =  Cart::content();
            Cart::add($quantite->id, $quantite->typeMatch, $request->quantite, $quantite->prix+$request->place, ['place' => $request->place]);
            $quantite->quantite = $quantite->quantite - $request->quantite;
            $quantite->save();
            return redirect()->route('billets.index', ['contenu' => $q])->with('success', 'Billet(s) ajouté(s) à votre panier');
        }
        return redirect()->route('billets.index')->withErrors('Quantité insuffisante de billets.');

    }

    public function destroy($id)
    {
        $item = Cart::get($id);
        $billet = Billet::where('id', $item->id)->first();
        $billet->quantite = $billet->quantite + $item->qty;
        $billet->save();
        Cart::remove($id);
        $reduc = session()->get('reduction')['montant'] ?? 0;
        $total = Cart::total() - $reduc;
        return view('panier', ['total' => $total]);
    }

    public function supprimer()
    {
        Cart::destroy();
        return view('panier');
    }

    public function update(Request $r, $id)
    {
        if($r->quantite < 0)
        {
        return redirect()->route('panier.index')->withErrors('Erreur de saisie, veuillez réesayer.');
        }
        else
        {
        Cart::update($id, $r->quantite);
        session()->forget('reduction');
        return redirect()->route('panier.index')->withSuccess('Quantité modifiée avec succès')->with('warning', 'Pensez à re-saisir votre code de réduction');
        }
    }
}
