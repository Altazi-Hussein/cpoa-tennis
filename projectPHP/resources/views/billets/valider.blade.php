@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Récapitulatif d'achat
                <a class="float-right" href="{{ URL::previous() }}">Retour</a></div>
                <div class="card-body">
                    @if (session()->has('success'))
                    <div class="alert alert-success">
                            {{ session()->get('success') }}
                    </div>
                    @endif
                @if (count($errors)>0)
                    <div class="alert alert-danger">
                            @foreach ($errors->all() as $error)
                                {{$error}}
                            @endforeach
                    </div>
                @endif
                    @if (session('status'))
                        <div class="alert alert-success" role="alert">
                            {{ session('status') }}
                        </div>
                    @endif
                    <h3>Informations personnelles</h3>
                    <form method="post" action="{{route('billets.store')}}">
                    @csrf
                    <label class="mt-2" for="nom">Nom *</label>
                    <input class="form-control form-control-lg" placeholder="Ex.: Dupont" id="nom" name="nom">

                    <label class="mt-2" for="prenom">Prénom *</label>
                    <input class="form-control form-control-lg" placeholder="Ex.: Christian" id="prenom" name="prenom">

                    <label class="mt-2" for="prenom">Date de naissance *</label>
                    <input type="date" class="form-control form-control-lg" placeholder="Ex.: 06/11/2000" id="dateNaissance" name="dateNaissance">

                    <label class="mt-2" for="prenom">Adresse *</label>
                    <input class="form-control form-control-lg" placeholder="Ex.: 20 Rue des Lilas" id="adresse" name="adresse">
                </form>
                <br><hr>
                <form method="post" action="{{-- {{route('billets.store')}} --}}">
                    @csrf
                <h3>Paiement</h3><br>
                <input class="form-control form-control-lg" placeholder="Numéro carte" id="numCarte" name="numCarte"><br>
                <input class="form-control form-control-lg" placeholder="Nom possesseur de la carte" id="nomCarte" name="nomCarte"><br>
                <div class="d-flex">
                <input class="form-control form-control-lg w-75 mr-2" placeholder="Date d'expiration (jj/mm/aaaa)" id="dateExpiration" name="dateExpiration">
                <input class="form-control form-control-lg w-25 ml-2" placeholder="CVV" id="cvv" name="cvv">
            </div><br>
            <div class="d-flex justify-content-between align-items-center">
            <img style="width:20%;cursor:pointer;" class="img-fluid" src="{{asset('images/paypal.jpg')}}">
            <img style="width:15%; height:15%; cursor:pointer;" class="img-fluid" src="{{asset('images/visa.jpg')}}">
            <input type="submit" class="btn btn-success btn-lg form-control w-50" value="Valider l'achat">
            </div>
        </div>
            </div>
        </div>
        <div class="card row ml-2 h-50">
            <div class="card-header">Vos billets</div>
            <div class="card-body">
            <table class="table">
                <thead>
                  <tr>
                    <th scope="col">Billet(s)</th>
                    <th scope="col">Quantité</th>
                  </tr>
                </thead>
                <tbody>
                    @foreach (Cart::content() as $item)
                    <tr>
                        <td>{{$item->name}}</td>
                        <td class="text-center">x{{$item->qty}}</td>
                      </tr>
                    @endforeach
                    <tr>
                        <th><h4>Total</h4></th>
                        <td class="text-center"><h4>{{$total}}€</h4></td>
                    </tr>
                </tbody>
              </table>
            </div>
        </div>
    </div>
</div>
@endsection
