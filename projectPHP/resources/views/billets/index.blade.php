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
                        @foreach ($billets as $billet)
                            <div class="d-flex justify-content-between">
                            <h3 for="grandPublic">{{$billet->typeMatch}}
                                <p style="font-size: 1.5vh; font-weight: 400;">Quantité restante: {{$billet->quantite}}</p>
                            <p style="font-size: 1.5vh; font-weight: 400; line-height:0">Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                            </h3>

                            <span class="align-self-center">
                            <input class="text-center form-control" type="number" value="0" min="0" max="{{$billet->quantite}}">
                            <p class="text-center">{{$billet->prix}}€</p>
                        </span>
                            </div>
                            <hr>
                        @endforeach
                        <input class="btn btn-success text-uppercase form-control" style="" type="button" value="Réserver" name="quantity" id="grandPublic">
                            
{{-- 
                        <div class="d-flex justify-content-between">
                        <h3 for="promo">Billets Promo 
                            <p style="font-size: 1.5vh; font-weight: 400;">Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                        
                        </h3>
                        <span class="d-flex flex-column justify-content-between">
                        <input class="text-right" type="number" value="1" min="1" max="20">
                        <input class="btn btn-success text-uppercase" type="button" value="Réserver" name="quantity" min="1" max="50" id="grandPublic">
                        </span>
                        </div>
                        <hr>
                        <div class="d-flex justify-content-between">
                        <h3 for="licencie">Billets Licenciés 
                            <p style="font-size: 1.5vh; font-weight: 400;">Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                        
                        </h3>
                        <span class="d-flex flex-column justify-content-between">
                            <input class="text-right" type="number" value="1" min="1" max="20">
                        <input class="btn btn-success text-uppercase" type="button" value="Réserver" name="quantity" min="1" max="50" id="grandPublic">
                        </span>
                    </div>
                        <hr>

                        <div class="d-flex justify-content-between">
                        <h3 for="journeeSolidarite">Billets Journée de la Solidarité 
                            <p style="font-size: 1.5vh; font-weight: 400;">Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                        
                        </h3>
                        <span class="d-flex flex-column justify-content-between">
                            <input class="text-right" type="number" value="1" min="1" max="20">
                        <input class="btn btn-success text-uppercase" type="button" value="Réserver" name="quantity" min="1" max="50" id="grandPublic">
                        </span>
                    </div>
                        <hr>

                        <div class="d-flex justify-content-between">
                        <h3 for="bigMatch">Billets Grand Public 
                            <p style="font-size: 1.5vh; font-weight: 400;">Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                        
                        </h3>
                        <span class="d-flex flex-column justify-content-between">
                            <input class="text-right" type="number" value="1" min="1" max="20">
                        <input class="btn btn-success text-uppercase" type="button" value="Réserver" name="quantity" min="1" max="50" id="grandPublic">
                        </span>
                    </div>

 --}}
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
