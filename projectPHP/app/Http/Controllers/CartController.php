<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Cart;

class CartController extends Controller
{
    public function index()
    {
        return view('panier');
    }

    public function add(Request $request)
    {
        $billet = Cart::add($request->id, $request->typeMatch, $request->quantite, $request->prix, [], $request->tax);
        return redirect()->route('billets.index', ['billet' => $billet])->with('success', 'Billet ajouté à votre panier');
    }

    public function destroy()
    {
        Cart::destroy();
        return view('panier');
    }
}
