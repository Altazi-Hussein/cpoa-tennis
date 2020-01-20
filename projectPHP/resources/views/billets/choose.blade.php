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
        <div class="col-md-7">
            <div class="card">
                <div class="card-header" style="text-transform: uppercase; background: white; color: #384d9b; font-weight: bold;">Achetez vos billets
                    <a class="float-right" href="{{ URL::to('/') }}">Retour</a>
                </div>
                <div class="card-body bg-white" style="font-size: 1.5vh;">
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
                    <form method="post" action="{{route('billets.choose')}}">
                        @csrf
                        <div class="form-group">
                        <label for="dateMatch">Choisissez la date du match</label>
                        <input class="form-control" type="date" name="dateMatch">
                        </div>
                        <div class="form-group">
                        <label for="court">Pour quel court ?</label>
                        <select name="court" class="form-control">
                            <option value="0">Court central </option>
                            <option value="1">Court annexe 1</option>
                            <option value="2">Court annexe 2</option>
                            <option value="3">Court annexe 3</option>
                        </select>
                        </div>
                        <input type="submit" class="form-control btn btn-success mt-4" value="Recherchez les billets disponibles" style="font-size: 1.8vh;">
                    </form>
                    </div>
{{--                 <a href="{{url::('billets.accueil')}}">Aller</a>
 --}}            </div>
        </div>
    </div>
</div>
@endsection
