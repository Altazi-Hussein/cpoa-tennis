<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Str;
use App\Billet;
use DB;

class BilletsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $billets = Billet::all();
        $var = Billet::where('id', 1)->get();
        return view('billets.index', ['billets' => $billets, 'var' => $var]);
    }


    public function accueil()
    {
        return view('billets.accueil');
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
        //
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
        $billet = Billet::findOrFail($id);
        return view('billets.edit', ['billet' => $billet, 'id' => $id]);
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
            'quantite' => 'required',
            'prix'     => 'required'
        ]);
        
        $billet = Billet::findOrFail($id);
        $billet->quantite = $request->get('quantite');
        $billet->prix = Str::replaceFirst(',', '.',$request->get('prix'));
        $billet->save();

        return redirect()->route('home')->with('success', 'Billet modifié avec succès !');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }

    public function choose()
    {
        return view('billets.choose');
    }
}
