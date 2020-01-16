@extends('layouts.app')

@section('content')
@php
    set_time_limit(0);
@endphp
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <div class="card">
                <div class="card-header" style="text-transform: uppercase; background: white; color: #384d9b; font-weight: bold;">Achetez vos billets
                <a class="float-right" href="{{ URL::previous() }}">Retour</a></div>
                @if(session()->has('success'))
                    <div class="alert alert-success">
                        {{ session()->get('success') }}
                    </div>
                @endif
                {{$var[0]}}
                <form action="{{url('add')}}" method="post">
                    @csrf
                    <input type="hidden" value="{{$var[0]['id']}}" name="id">
                    <input type="hidden" value="{{$var[0]['typeMatch']}}" name="typeMatch">
                    <input type="number" value="1" name="quantite">
                    <input type="hidden" value="{{$var[0]['prix']}}" name="prix">
                    <input type="submit" value="Ajouter"><br>
                </form>
                <img src="{{asset('images/billetsbg.jpg')}}" style="height: 50vh;">
                <div class="card-body" style="background: #384d9b; color:white;font-size: 1.8vh; opacity: 0.95;">
                        
                        @foreach ($billets as $billet)
                            <div class="d-flex justify-content-between">
                            <h3>{{$billet->typeMatch}}
                            <p style="font-size: 1.5vh; font-weight: 400;">Quantité restante: {{$billet->quantite}}. Id: {{$billet->id}}</p>
                            <p style="font-size: 1.5vh; font-weight: 400; line-height:0">Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                            </h3>
                            <form class="column" action="{{url('add')}}" method="post">
                            @csrf
                            <div class="d-flex align-self-center">
                                <input type="hidden" value="{{$billet->id}}" name="id">
                                <input type="hidden" value="{{$billet->typeMatch}}" name="typeMatch">
                                <input type="hidden" value="{{$billet->prix}}" name="prix">
                                <input type="hidden" value="0" name="tax">
                                <input type="number" class="form-control text-center mr-2" value="1" name="quantite" style="width: 6vh;">
                                <button type="submit" class="btn btn-success form-control">
                                    <i class="fas fa-check"></i>
                                </button>
                            </div>
                            </form>
                            </div>
                            <hr>
                        @endforeach

                    <a class="btn btn-info form-control" style="font-size: 2vh;" href="{{ url('panier') }}">
                        <i class="fas fa-shopping-cart"></i>{{ __(' Panier') }}
                        <span>({{Cart::count()}})</span>
                    </a>                </div>
            </div>
        </div>
    </div>
</div>
@endsection
