@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Gestion du panier
                    @if (session()->has('success'))
                    <div class="alert alert-success">
                            {{ session()->get('success') }}
                    </div>
                    @endif

                    @if (count($errors)>0)
                        <div class="alert alert-danger">
                         <ul>
                            @foreach ($errors->all() as $error)
                                <li>{{$error}}</li>
                            @endforeach
                        </ul>
                    @endif
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
                    <h4>Votre panier</h4>
                    <hr>
                    @if (Cart::count()>0)
                    @foreach (Cart::content() as $item)
                <h4>{{$item->name}} {{$item->qty}} {{$item->price}}€</h4>
                    @endforeach
                        {{Cart::content()}}<br>
                        <p style="color: blue;">{{Cart::content()->where('id', '3')}}</p>
                        {{Cart::total() .  '€'}}<br>
                        <h2>{{Cart::count()}} billets dans votre panier</h2>
                        <input placeholder="Insérez votre code ici" class="form-control" type="text"><br>
                        <input class="btn btn-primary form-control" type="submit" value="Appliquer">
                    @else
                    <h5> Pas de billets dans votre panier</h5>
                    <a class="btn btn-primary" style="font-size:1.8vh;" href="{{url('billets')}}">Achetez</a>
                    @endif

                    <form action="{{url('destroy')}}" method="post">
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