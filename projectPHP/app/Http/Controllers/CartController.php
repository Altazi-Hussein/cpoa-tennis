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
        Cart::tax('0');
        $quantite = Billet::findOrFail($request->id);
        if($quantite->quantite >= $request->quantite)
        {
            $billet = Cart::add($request->id, $request->typeMatch, $request->quantite, $request->prix, []);
            $quantite->quantite = $quantite->quantite - $request->quantite;
            $quantite->save();
            return redirect()->route('billets.index', ['billet' => $billet, 'quantite' => $quantite])->with('success', 'Billet(s) ajouté(s) à votre panier');
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
        return view('panier');
    }

    public function supprimer()
    {
        Cart::destroy();
        return view('panier');
    }

    public function update(Request $r, $id)
    {
        Cart::update($id, $r->quantite);
        session()->forget('reduction');
        return redirect()->route('panier.index')->withSuccess('Quantité modifiée avec succès')->with('warning', 'Pensez à re-saisir votre code de réduction');
    }
}
