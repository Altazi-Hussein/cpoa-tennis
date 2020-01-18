<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Laravel</title>

        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,600" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Bungee+Inline&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
        <!-- Styles -->

        <script src="https://kit.fontawesome.com/4d9f9c2bbc.js" crossorigin="anonymous"></script>

        <style>
            html, body {
               /* background: url('{{asset('images/background.jpg')}}');*/
                background-image: url('https://images7.alphacoders.com/734/734192.jpg');
                background-size: cover;
                color: black;
                font-family: 'Nunito', sans-serif;
                font-weight: 200;
                height: 100vh;
                margin: 0;
                padding:0;
            }

            h1
            {
                font-family: 'Bungee Inline', cursive;
                text-align: center;
                margin: 0;
                padding: 0;
                line-height: 5vw;
                font-size: 5vw;
            }

            h2
            {
                font-family: 'Bungee Inline', cursive;
                text-align: center;
                margin: 0;
                padding: 0;
                line-height: 4vw;
                font-size: 4vw;
                text-align: center;
            }

            h3,h4,h5,h6
            {
                line-height: 10vh;
                margin: 0;
            }

            a,input,form
            {
                text-decoration:none; 
                color: white;
                font-size: 2vh;
                text-align:center;
                color:black;
                text-transform: uppercase;
                font-family: Roboto, 'sans-serif';
            }

            .full-height {
                height: 100vh;
            }

            .flex-center {
                align-items: center;
                display: flex;
                justify-content: center;
            }

            .position-ref {
                position: relative;
            }

            .top-right {
                position: absolute;
                right: 10px;
                top: 18px;
            }

           hr
           {
               border: 0.2vh solid black;
               margin:0;
           }

           .main
           {
               display: flex;
               justify-content: space-around;
           }

            a,input,form
            {
                border: none;
                background:white;
                font-size: 2.5vh;
                transition-duration: 500ms;
                padding:1vw;
                cursor: pointer;
            }

            form
            {
                height: 10vh;
                margin: 0;
                padding: 0;
                background: blue;
                display: flex;
            }

            input
            {
                border:none;
                background:white;                
            }


            a:hover, input:hover
            {
                border: none;
                font-weight: bold;
                background: black;
                padding:1vh;
                color:white;
                font-size: 3vh;
                transition-duration: 500ms;
            } 
        </style>
    </head>
    <body>
        <div class="flex-center full-height">
            <div class="d-flex" style="padding:2vh;width:40vw;height:40vh;">
                <h2>Open</h2>
                <h1>Parc</h1>
                <hr>
                <div class="main">
                <a href="#">Découvrir l'événement</a>
                {{-- <a href="{{route('billets.choose')}}">Accéder à la billeterie</a> --}}
                <form action="{{ route('billets.choose')}}" method="post" style="line-height: 25vh;">
                    @csrf
                    <input type="submit" value="Achetez vos billets">
                </form>
                <a href="#">Découvrir le planning</a>
                </div>
                    </div>
                </div>
                {{--  <a href="#" style="line-height: 10vh;">
                    <div style="background: url('../public/images/evenement.jpg'); background-size:300%; background-position: center; font-size:3vh;">
                        <p>Découvrir l'événement</p>
                    </div>
                </a>
            
                <form action="{{ route('billets.choose')}}" method="post" style="line-height: 25vh;">
                    @csrf
                    <button type="submit" style="background: url('../public/images/billets.jpg'); background-size:300%; background-position: center; font-size:3vh;">
                        Achetez vos billets
                    </button>
                </form>
 --}}
            </div>
        </div>
    </body>
</html>
