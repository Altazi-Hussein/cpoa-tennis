@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <div class="card">
                <div class="card-header" style="text-transform: uppercase; background: white; color: #384d9b; font-weight: bold;">Achetez vos billets
                <a class="float-right" href="{{ URL::previous() }}">Retour</a></div>
                <img src="{{asset('images/billetsbg.jpg')}}">
                <div class="card-body" style="background: #384d9b; color:white;font-size: 1.8vh; opacity: 0.95;">
                    
                    <form class="column">
                        <div class="d-flex justify-content-between">
                        <h3 for="grandPublic">Billets Grand Public </h3>
                        <input class="btn btn-success text-uppercase" type="button" value="Réserver" name="quantity" min="1" max="50" id="grandPublic">
                        </div>
                        <p>Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                        <hr>

                        <div class="d-flex justify-content-between">
                        <h3 for="promo">Billets Promo </h3>
                        <input class="btn btn-success text-uppercase" type="button" value="Réserver" name="quantity" min="1" max="50" id="grandPublic">
                        </div>
                        <p>Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                        <hr>
                        <div class="d-flex justify-content-between">
                        <h3 for="licencie">Billets Licenciés </h3>
                        <input class="btn btn-success text-uppercase" type="button" value="Réserver" name="quantity" min="1" max="50" id="grandPublic">
                        </div>
                        <p>Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                        <hr>

                        <div class="d-flex justify-content-between">
                        <h3 for="journeeSolidarite">Billets Journée de la Solidarité </h3>
                        <input class="btn btn-success text-uppercase" type="button" value="Réserver" name="quantity" min="1" max="50" id="grandPublic">
                        </div>
                        <p>Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                        <hr>

                        <div class="d-flex justify-content-between">
                        <h3 for="bigMatch">Billets Grand Public </h3>
                        <input class="btn btn-success text-uppercase" type="button" value="Réserver" name="quantity" min="1" max="50" id="grandPublic">
                        </div>
                        <p>Du Samedi 16/05/2020 au Samedi 23/05/2020</p>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
