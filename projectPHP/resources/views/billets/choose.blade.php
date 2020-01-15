@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <div class="card">
                <div class="card-header" style="text-transform: uppercase; background: white; color: #384d9b; font-weight: bold;">Achetez vos billets
                    <a class="float-right" href="{{ URL::to('/') }}">Retour</a>
                </div>
                
                <div class="card-body" style="background: #384d9b; color:white;font-size: 1.8vh; opacity: 0.95;">
                    <form method="get" action="{{ action('BilletsController@index') }}">
                        @csrf
                        <div class="form-group">
                        <label for="dateMatch">Choisissez la date du match</label>
                        <input class="form-control" type="date" name="dateMatch">
                        </div>

                        <div class="form-group">
                        <label for="court">Pour quel court ?</label>
                        <select class="form-control">
                            <option>Court central</option>
                            <option>Court annexe</option>
                            <option>Finale</option>
                        </select>
                        </div>

                    <input type="submit" class="btn btn-success mt-4" value="Trouver des billets" style="font-size: 1.8vh;">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
