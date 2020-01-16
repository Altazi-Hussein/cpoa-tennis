@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <div class="card">
                <div class="card-header" style="text-transform: uppercase; background: white; color: #384d9b; font-weight: bold;">Achetez vos billets
                <a class="float-right" href="{{ URL::previous() }}">Retour</a></div>
                <img src="{{asset('images/billetsbg.jpg')}}" style="height: 50vh;">
                <div class="card-body" style="background: #384d9b; color:white;font-size: 1.8vh; opacity: 0.95;">
                        <form class="column">
                        {{-- @foreach ($billets as $billet)
                            <div class="d-flex justify-content-between">
                            <h3 for="grandPublic">{{$billet->typeMatch}}
                                <p style="font-size: 1.5vh; font-weight: 400;">Quantité restante: {{$billet->quantite}}</p>
                            <p style="font-size: 1.5vh; font-weight: 400; line-height:0">Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                            </h3>
                        <form action="{{route('panier.store')}}">
                            @csrf
                            <input type="hidden" name="id" value="{{$billet->id}}">
                            <input type="hidden" name="quantite" value="{{$billet->quantite}}">
                            <input type="hidden" name="prix" value="{{$billet->prix}}">
                            <input type="submit" class="btn btn-primary" value="Ajouter">
                        </form>

                           <span class="align-self-center">
                            <input class="text-center form-control" type="number" value="0" min="0" max="{{$billet->quantite}}">
                            <p class="text-center">{{$billet->prix}}€</p>
                        </span>
                            </div>
                            <hr>
                        @endforeach --}}
                        <input class="btn btn-success text-uppercase form-control" style="" type="button" value="Réserver" name="quantity" id="grandPublic">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
