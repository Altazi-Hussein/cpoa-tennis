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
                <a class="float-right" href="{{ route('choose') }}">Retour</a></div>
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

                @php
                foreach (Cart::content() as $item) {
                    if ($item->name == "Licenciés") {
                        $check = true;
                    } else {
                        $check = false;
                    }
                }
                @endphp

                {{-- <form action="{{url('add')}}" method="post">
                    @csrf
                    <input type="hidden" value="{{$var[0]['id']}}" name="id">
                    <input type="hidden" value="{{$var[0]['typeMatch']}}" name="typeMatch">
                    <input type="number" value="1" name="quantite">
                    <input type="hidden" value="{{$var[0]['prix']}}" name="prix">
                    <input type="submit" value="Ajouter"><br>
                </form> --}}
                <img src="{{asset('images/billetsbg.jpg')}}" style="height: 50vh;">
                <div class="card-body bg-light" style="background: #384d9b; color:black;font-size: 1.8vh; opacity: 0.95;">
                <h4 class="text-center">Billets pour la journée {{session()->get('matchExiste')['dateMatch']}}</h4>
                <h5 class="text-center">
                    Court 
                    @switch(session()->get('matchExiste')['court'])
                        @case(0)
                            {{"central"}}
                            @break
                        @case(1)
                            {{"annexe 1"}}
                            @break
                        @case(2)
                            {{"annexe 2"}}
                            @break;
                        @case(3)
                            {{"annexe 3"}}
                            @break;
                        @default
                            
                    @endswitch
                </h5>
                    <hr>
                        @foreach ($billets as $billet)
                            @if ($billet->quantite>0)
                            @if ($billet->typeMatch=="Licenciés" && !$check || $billet->typeMatch!="Licenciés")
                            <div class="d-flex justify-content-between">
                                <h3>{{$billet->typeMatch}}
                                <p style="font-size: 1.5vh; font-weight: 400;">Quantité restante: {{$billet->quantite}}.</p>
                                </h3>
                                <form class="column" action="{{url('add')}}" method="post">
                                @csrf
                                <div class="d-flex align-self-center">
                                    <input type="hidden" value="{{$billet->id}}" name="id">
                                    <input type="hidden" value="{{$billet->typeMatch}}" name="typeMatch">
                                    <input type="hidden" value="{{$billet->prix}}" name="prix">
                                    <select class="form-control mr-2" name="place">
                                        <option value="0">Placement libre (0€)</option>
                                        <option value="15">Niveaux 1 et 2 (+15€)</option>
                                        <option value="30">Niveaux 3 (+30€)</option>
                                    </select>
                                    @if ($billet->typeMatch == "Licenciés")
                                    <input type="number" class="form-control text-center mr-2"  style="width: 6vh;" value="1" name="quantite" readonly>
                                    @else
                                    <input type="number" class="form-control text-center mr-2" value="1" name="quantite" style="width: 6vh;">
                                    @endif
                                    <button type="submit" class="btn btn-success">
                                        <i class="fas fa-check"></i>
                                    </button>
                                </div>
                                </form>
                            </div>
                            <hr>
                            @else
                            <div class="d-flex justify-content-between" style="opacity: 0.5;">
                                <h3>{{$billet->typeMatch}} (déjà dans votre panier)
                                <p style="font-size: 1.5vh; font-weight: 400;">Déjà acheté</p>
                                <p style="font-size: 1.5vh; font-weight: 400; line-height:0">Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                                </h3>
                                <form class="column" method="post">
                                @csrf
                                <div class="d-flex align-self-center">
                                    <input type="number" class="form-control text-center mr-2" value="0" name="quantite" style="width: 6vh;" readonly>
                                    <button type="submit" class="btn btn-danger form-control">
                                        <i class="fas fa-times"></i>
                                    </button>
                                </div>
                                </form>
                            </div>
                            <hr>
                            @endif
                            @else
                            <div class="d-flex justify-content-between" style="opacity: 0.5;">
                                <h3>{{$billet->typeMatch}}
                                <p style="font-size: 1.5vh; font-weight: 400;">Quantité insuffisante.</p>
                                <p style="font-size: 1.5vh; font-weight: 400; line-height:0">Du Samedi 16/05/2020 au Samedi 23/05/2020</p>
                                </h3>
                                <form class="column" action="" method="post">
                                @csrf
                                <div class="d-flex align-self-center">
                                    <input type="number" class="form-control text-center mr-2" value="0" name="quantite" style="width: 6vh;" readonly>
                                    <button type="submit" class="btn btn-danger form-control">
                                        <i class="fas fa-times"></i>
                                    </button>
                                </div>
                                </form>
                            </div>
                            <hr>
                            @endif
                            
                        @endforeach

                    <a class="btn btn-primary form-control" style="font-size: 2vh;" href="{{ url('panier') }}">
                        <i class="fas fa-shopping-cart"></i>{{ __(' Panier') }}
                        <span>({{Cart::count()}})</span>
                    </a>                </div>
            </div>
        </div>
    </div>
</div>
@endsection
