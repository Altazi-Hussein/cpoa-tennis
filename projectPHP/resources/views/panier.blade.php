@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Panel d'administration
                <a class="float-right" href="{{ URL::to('/') }}">Accueil</a></div>
                @if (count($errors)>0)
                    <div class="alert alert-danger">
                        <ul>
                            @foreach ($errors->all() as $error)
                                <li>{{$error}}</li>
                            @endforeach
                        </ul>
                @endif
                <div class="card-body">
                    <h3>Votre panier</h3>
                    <hr>
                    <input placeholder="Insérez votre code ici" class="form-control" type="text"><br>
                    <input class="btn btn-primary form-control" type="submit" value="Appliquer">
                </div>
            </div>
        </div>
    </div>
</div>
@endsection