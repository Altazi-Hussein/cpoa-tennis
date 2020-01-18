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
                    <h3 class="mb-4">Gestion des billets</h3>
                    <table class="table table-hover table-bordered">
                        <thead>
                          <tr class="text-center">
                            <th>Nom du billet</th>
                            <th>Prix</th>
                            <th>Quantité</th>
                            <th>Éditer</th>
                            <th>Supprimer</th>
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
                                <td class="align-middle">
                                    <form action="{{URL::route('billets.destroy', $billet->id)}}" method="post">
                                        @csrf
                                        @method('delete')
                                        <button onclick="return confirm('Voulez-vous vraiment supprimer cette réduction ?');" type="submit" class="btn btn-danger btn-sm m-1">
                                           <i class="fas fa-times"></i>
                                        </button>         
                                    </form>
                                </td>
                            <tr>
                            @endforeach
                        </tbody>
                      </table>
                      <form class="mb-5" action="{{route('billets.create')}}" method="GET">
                        @csrf
                        <button type="submit" class="btn btn-primary float-right">
                            Nouveau billet
                        </button>
                    </form>

                    <h3 class="mb-4 mt-4">Gestion des codes de réduction</h3>
                    <table class="table table-hover table-bordered">
                        <thead>
                          <tr class="text-center">
                            <th>Code</th>
                            <th>Billet concerné</th>
                            <th>Réduction</th>
                            <th>Quantité</th>
                            <th>Éditer</th>
                            <th>Supprimer</th>
                          </tr>
                        </thead>

                        <tbody>
                            @foreach ($coupons as $coupon)
                            <tr class="text-center">
                                <td class="align-middle">{{$coupon->code}}</td>
                                <td class="align-middle">{{$coupon->getBillet()->typeMatch}}</td>
                                <td class="align-middle">{{$coupon->reduction}}%
                                </td>
                                    @if ($coupon->quantite>0)
                                    <td class="align-middle">
                                        {{$coupon->quantite}}
                                    </td>
                                    @else
                                    <td class="align-middle text-danger">
                                        {{$coupon->quantite}}
                                    </td>
                                    @endif
                                   
                                </td>
                                <td class="align-middle">
                                    <form action="{{route('coupon.edit', $coupon) }}" method="GET">
                                        @csrf
                                        <button type="submit" class="btn btn-warning btn-sm m-1">
                                           <i class="far fa-edit"></i>
                                        </button>         
                                    </form>
                                </td>
                                <td class="align-middle">
                                    <form action="{{URL::route('coupon.retirer', $coupon->id)}}" method="post">
                                        @csrf
                                        @method('delete')
                                        <button onclick="return confirm('Voulez-vous vraiment supprimer cette réduction ?');" type="submit" class="btn btn-danger btn-sm m-1">
                                           <i class="fas fa-times"></i>
                                        </button>         
                                    </form>
                                </td>
                            <tr>
                            @endforeach
                        </tbody>
                      </table>
                      <form action="{{route('coupon.create')}}" method="GET">
                        @csrf
                        <button type="submit" class="btn btn-primary float-right">
                           Ajouter une réduction
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
