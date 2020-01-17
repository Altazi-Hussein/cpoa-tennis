@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Panel d'administration
                <a class="float-right" href="{{ URL::to('/') }}">Accueil</a></div>
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
                    <h3>Gestion des billets</h3>
                    <hr>
                    <form method="post" action="{{action('BilletsController@update', $id)}}">
                    @csrf
                    @method('PATCH')
                    <label class="mt-2" for="typeMatch">Type de billet</label>
                    <input class="form-control" placeholder="{{$billet->typeMatch}}" id="typeMatch" name="typeMatch" readonly>

                    <label class="mt-2" for="prix">Prix du billet</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                          <div class="input-group-text">€</div>
                        </div>
                    <input class="form-control" value="{{$billet->prix}}" id="prix "name="prix">
                    </div>
                    <label class="mt-2" for="quantite">Quantité</label>
                    <input class="form-control" value="{{$billet->quantite}}" id="quantite" name="quantite">

                    <input class="float-right btn btn-success form-control w-75 mt-4" type="submit" value="Éditer le billet">
                    <a class="float-right btn btn-danger form-control w-25 mt-4" href="{{ URL::to('home') }}">Annuler</a>

                </form>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
