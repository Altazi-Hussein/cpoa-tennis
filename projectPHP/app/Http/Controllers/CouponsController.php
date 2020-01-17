<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Coupon;
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
        //
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $code = Coupon::where('code', $request->code)->first();
        if(!$code)
        {
            return redirect()->route('panier.index')->withErrors('Code invalide, veuillez réessayer');
        }

        session()->put('reduction', [
            'code' => $code->code,
            'montant' => $code->discount(Cart::total()),
            'pourcentage' => $code->reduction,
        ]);

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
        //
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
        //
    }

    public function supprimer()
    {
        session()->forget('reduction');

        return redirect()->route('panier.index')->withSuccess('Réduction supprimée.');
    }
}
