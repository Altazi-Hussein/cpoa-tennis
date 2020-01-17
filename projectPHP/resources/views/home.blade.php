@extends('layouts.app')


@section('head')
<style>
html
{
background-size:cover;
}
</style>
@endsection


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
                    <h3>Gestion des billets</h3>
                    <hr>
                    <table class="table table-hover table-bordered">
                        <thead>
                          <tr class="text-center">
                            <th>Nom du billet</th>
                            <th>Prix</th>
                            <th>Quantité</th>
                            <th>Éditer</th>
                          </tr>
                        </thead>

                        <tbody>
                            @foreach ($billets as $billet)
                            <tr class="text-center">
                                <td class="align-middle">{{$billet->typeMatch}}</td>
                                <td class="align-middle">{{$billet->prix}}€
                                </td>
                                    @if ($billet->quantite>0)
                                    <td class="align-middle">
                                        {{$billet->quantite}}
                                    </td>
                                    @else
                                    <td class="align-middle text-danger">
                                        {{$billet->quantite}}
                                    </td>
                                    @endif
                                   
                                </td>
                                <td class="align-middle">
                                    <form action="{{route('billets.edit', $billet) }}" method="GET">
                                        @csrf
                                        <button type="submit" class="btn btn-warning btn-sm m-1">
                                           <i class="far fa-edit"></i>
                                        </button>         
                                    </form>
                                </td>
                            <tr>
                            @endforeach
                        </tbody>
                      </table>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
