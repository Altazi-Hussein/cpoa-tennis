@extends('layouts.app')

@section('head')
<script>

function myFunction()
{
    var message = Math.random().toString(36);
    document.getElementById("code").value = message;
}
 </script>

@endsection

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Panel d'administration
                <a class="float-right" href="{{ URL::to('/') }}">Accueil</a></div>
                <div class="card-body">
                @if (count($errors)>0)
                    <div class="alert alert-danger">
                            @foreach ($errors->all() as $error)
                                {{$error}}
                            @endforeach
                    </div>
                @endif
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
                    <h3>Ajouter une réduction</h3>
                    <hr>
                    <form method="post" action="{{action('CouponsController@save')}}">
                    @csrf
                    <label class="mt-3" for="code">Code de réduction</label>
                    <div class="input-group">
                        
                    
                    <input class="form-control" id="code" name="code">
                    <div class="input-group-prepend">
                    <div onclick="myFunction()" style="cursor:pointer;" class="input-group-text">Générer un code aléatoire</div>
                    </div>
                </div>
                    <label class="mt-3" for="idBillet">Billet concerné</label>
                    <select class="form-control" name="idBillet" id="idBillet">
                        @foreach ($billets as $billet)
                            <option value="{{$billet->id}}">{{$billet->typeMatch}}</option>
                        @endforeach
                    </select>

                    <label class="mt-3" for="pourcentage">Réduction accordée</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                          <div class="input-group-text">%</div>
                        </div>
                    <input class="form-control" id="reduction "name="reduction">
                    </div>
                    <label class="mt-3" for="quantite">Quantité</label>
                    <input class="form-control" id="quantite" name="quantite">

                    <input class="float-right btn btn-success form-control w-75 mt-4" type="submit" value="Ajouter la réduction">
                    <a class="float-right btn btn-danger form-control w-25 mt-4" href="{{ URL::to('home') }}">Annuler</a>

                </form>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
