<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <title>Jeu de Pendu</title>
    <meta name="description" content="">
    <meta name=viewport content="width=device-width, initial-scale=1">
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.13.0/css/semantic.min.css">
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400,700,300&subset=latin,vietnamese' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="main.css">
</head>
<body>
    <div class="ui grid labeled">
        <div class="">
            <div class="ui inverted fixed menu navbar page grid">
                <a href="" class="brand item">Jeu de Pendu</a>
                <a href="" class="active item"><i class="gamepad icon"></i></a>                
                <div class="right menu">
                   <a href="" class="item"><i class="github icon"></i></a>
                </div>
            </div>
        </div>
    </div>

    <div class="ui page grid main">
        <div class="row">
            <div class="column padding-reset">
                <div class="ui large message">
                    <form action="submit" method="POST">
                        <div class="column">
                            <img class="img-thumbnail" src="assets/hangman/6.png" width="200" height="200">
                            <h1></h1>
                            <div class="ui divider"></div>
                        </div>
                        <div class="ui segment">
                            <div class="ui form">
                                <div class="two fields">
                                   <div class="inline field">
                                        <label>Guess the Country!</label>
                                        <input type="text" name="letter" onClick="return validation()">
                                    </div>
                                </div>
                                <div class="ui submit button">Submit</div>      
                            </div>                           
                        </div>
                    </form>
                    <form action="Envoyer"  method="POST">
                        <input type="text" name="input" value="" />
                        <input type="submit" value="input" />
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.13.0/javascript/semantic.min.js"></script>
    <script src="main.js"></script>
</body>
</html>