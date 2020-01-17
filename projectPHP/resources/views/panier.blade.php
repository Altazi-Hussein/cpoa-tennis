@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Gestion du panier
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
                <h4>Votre panier ({{Cart::count()}})</h4><br>
                    @if (Cart::count()>0)
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="col"><i class="fas fa-ticket-alt"></i> Billet</th>
                            <th class="text-center"scope="col">Quantité</th>
                            <th class="text-center"scope="col">Prix</th>
                          </tr>
                        </thead>
                        <tbody>
                            @foreach (Cart::content() as $item)
                            <tr>
                            <td><div class="d-flex">
                                <h5>{{$item->name}}</h5>
                                <form action="{{URL::route('panier.destroy', array('id' => $item->rowId))}}" method="post">
                                    @csrf
                                    <input type="hidden" value="{{$item->rowId}}" name="id">
                                    <button type="submit" class="btn btn-sm text-danger">
                                        Supprimer
                                    </button>
                                </form>
                                </div>
                                <div class="d-flex">
                                <br>
                                <form action="{{route('coupon.store')}}" method="post">
                                @csrf
                                <div class="d-flex">
                                <input placeholder="Code promo ?" name="code" id="code" class="form-control form-control-sm w-75 mr-2" type="text">
                                <button type="submit" class="form-control form-control-sm btn btn-primary w-25">
                                    <i class="fas fa-check"></i>
                                </button>
                                </div>
                                </form>
                            </div>
                            </td>
                            <td class="text-center align-middle"><h5>{{$item->qty}}</h5></td>
                            <td class="text-center align-middle" ><h5>{{$item->price}}€</h5></td>
                            </tr>
                            @endforeach
                            @if(session()->has('reduction'))
                            <tr>
                                <td class="align-middle"><h4>Réductions</h4>
                                <div class="d-flex">
                                <h5>({{session()->get('reduction')['code']}}) {{session()->get('reduction')['pourcentage']}}%</h5>
                                <form action="{{route('coupon.delete')}}" method="post">
                                    @csrf
                                    @method('delete')
                                    <button type="submit" class="btn btn-sm text-danger">
                                        Supprimer
                                    </button>
                                </form>
                                </td>
                                <td></td>
                                <td class="text-center align-middle"><h5>-{{session()->get('reduction')['montant']}}€</h5></td>
                            </tr>
                            @endif
                            <tr class="bg-light">
                                <td class="align-middle"><h4>Total</h4></td>
                                <td></td>
                                <td class="text-center align-middle"><h5>{{$total ?? 0}}€</h5></td>
                            </tr>
                        </tbody>
                      </table>
                      <div class="d-flex justify-content-between">
                      <form method="post" action="{{route('billets.choose')}}">
                        @csrf
                        <button class="btn btn-secondary" type="submit">
                            Autres billets
                        </form>
                        <form method="post" action="{{route('billets.choose')}}">
                            @csrf
                            <button class="btn btn-success" type="submit">
                                Valider l'achat
                        </form>
                      </div>
                        {{-- {{Cart::content()}}<br>
                        <p style="color: blue;">{{Cart::content()->where('id', '3')}}</p>
                        {{Cart::total() .  '€'}}<br> --}}
                    @else
                    <h5> Pas de billets dans votre panier</h5>
                    <form method="post" action="{{route('billets.choose')}}">
                        @csrf
                        <button class="btn btn-primary" type="submit">
                            Boutique
                    </form>
                    @endif
                </div>
                    <form action="{{route('panier.supprimer')}}" method="post">
                        @csrf
                        <input type="submit" value="Tout supprimer"><br>
                    </form>
                    <form action="{{url('add')}}" method="post">
                        @csrf
                        <input type="submit" value="Ajouter billets"><br>
                    </form>
                    </div>
            </div>
        </div>
    </div>
</div>
@endsection