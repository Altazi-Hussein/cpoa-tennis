<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\{Coupon,Billet};
use Cart;


class CouponsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('coupon.create', ['billets' => Billet::all()]);
    }

    public function save(Request $request)
    {
        $this->validate($request, [
            'code' => 'required',
            'reduction'     => 'required',
            'quantite' => 'required',
            'idBillet' => 'required',
        ]);

        if($request->reduction<=0 || $request->quantite<0)
        {
            return redirect()->route('coupon.create')->withErrors('Réduction et/ou quantité erronées');
        }
        $coupon = new Coupon();
        $coupon->code = $request->code;
        $coupon->idBillet = $request->idBillet;
        $coupon->reduction = $request->reduction;
        $coupon->quantite = $request->quantite;
        $coupon->save();
        return redirect()->route('home')->with('success', 'Coupon ajouté avec succès');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $code = Coupon::where('code', $request->code)->where('idBillet', $request->idBillet)->first();
        if(!$code)
        {
            return redirect()->route('panier.index')->withErrors('Code invalide, veuillez réessayer');
        }

        if($code->quantite<=0)
        {
            return redirect()->route('panier.index')->withErrors('Ce code n\'est plus valable.');
        }

        session()->put('reduction', [
            'code' => $code->code,
            'montant' => $code->discount(Cart::total()),
            'pourcentage' => $code->reduction,
        ]);
        $code->quantite = $code->quantite - 1;
        $code->save();

        return redirect()->route('panier.index')->withSuccess('Réduction appliquée');

    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $coupon = Coupon::findOrFail($id);
        $billets = Billet::all();
        return view('coupon.edit', ['coupon' => $coupon, 'billets' => $billets]);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $this->validate($request, [
            'code' => 'required',
            'reduction'     => 'required',
            'quantite' => 'required',
            'idBillet' => 'required',
        ]);
        $coupon = Coupon::findOrFail($id);

        if($request->reduction<=0 || $request->quantite<0)
        {
            return redirect()->route('coupons.edit')->withErrors('Valeurs non valides');
        }

        $coupon->code = $request->code;
        $coupon->idBillet = $request->idBillet;
        $coupon->reduction = $request->reduction;
        $coupon->quantite = $request->quantite;
        $coupon->save();
        return redirect()->route('home')->with('success', 'Coupon modifié avec succès');

    }

    public function supprimer()
    {
        $code = session()->get('reduction')['code'];
        $coupon = Coupon::where('code', $code)->first();
        $coupon->quantite = $coupon->quantite + 1;
        $coupon->save();
        session()->forget('reduction');
        return redirect()->route('panier.index')->withSuccess('Réduction supprimée.');
    
    }

    public function retirer($id)
    {

        $coupon = Coupon::where('id', $id)->first();
        $coupon->delete();
        return redirect()->route('home')->withSuccess('Réduction supprimée avec succès');
    }
}
