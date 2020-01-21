<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Str;
use App\Billet;
use App\Models\Match;
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
        return view('billets.index', ['billets' => $billets]);
    }

    public function choose(Request $r)
    {
        if(session()->has('matchExiste') && $r->supprimer)
        {
            session()->forget('matchExiste');
        }
        $matchs = Match::where('dateDebutM', $r->dateMatch)->where('idCourt', $r->court)->first();
        if($matchs)
        {
            session()->put('matchExiste', [
                'dateMatch' => $r->dateMatch,
                'court' => $r->court,
            ]);
            return redirect()->route('billets.index');
        } else {
            return redirect()->route('choose')->withErrors('Pas de date sélectionnée');
        }
    }

    public function valider(request $r)
    {
        $total = $r->total;
        return view('billets.valider', ['total' => $total]);
    }

    public function accueil(Request $r)
    {
        $match = Match::where('dateDebutM', $r->dateMatch)->get();
        if(!$match)
        {
            return redirect()->route('billets.index');
        }
        return redirect()->route('billets.index');
    }
    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('billets.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $this->validate($request, [
            'quantite' => 'required',
            'prix'     => 'required'
        ]);

        if(!$request->typeMatch || $request->prix<=0 || $request->quantite<0)
        {
            return redirect()->route('billets.create')->withErrors('Erreur de saisie. Veuillez réessayer.');
        }

        $billet = new Billet();
        $billet->typeMatch = $request->typeMatch;
        $billet->prix = $request->prix;
        $billet->quantite = $request->quantite;
        $billet->save();
        return redirect()->route('home')->withSuccess('Billet ajouté avec succès.');
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
        if($request->quantite>=0 && $request->prix>=0)
        {
        $billet->quantite = $request->get('quantite');
        $billet->prix = Str::replaceFirst(',', '.',$request->get('prix'));
        $billet->save();
        return redirect()->route('home')->with('success', 'Billet modifié avec succès !');
        }
        else
        {
            return redirect()->route('billets.edit', $billet)->withErrors('Valeurs invalides.');
        }

    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $billet = Billet::where('id', $id)->first();
        $billet->delete();
        return redirect()->route('home')->withSuccess('Billet supprimé avec succès');
    }
}
