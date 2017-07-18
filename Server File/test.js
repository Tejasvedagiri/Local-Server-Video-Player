var express = require('express');
var app =express();
var connections = [];
var server = (require)('http').createServer(app)
var io = require('socket.io').listen(server)
var sql_query = ""
var Name= [];
var URL = [];

//Mysql Settings
var mysql = require('mysql');
var connection = mysql.createConnection({
	host:'localhost',
	user: 'root',
	password: '',
	database: 'video'
});


//Mysql Connection
connection.connect(function(error){
	if(!!error){
		console.log('Could Not connect to database');
		process.exit(1);
		}
	else {
		console.log('Database -- OK');
	}
});


//Mysql Video Count
sql_query = "select count(*) as cnt from video";
connection.query(sql_query,function(error,result){
    var row=result[0].cnt;
     count=row;
     if(!!error){
        console.log('Error at Updating server');
        process.exit(1);
    }
    else {
        console.log("Videos Loaded - " + count);
    }
});

//Loading MetaData from server
sql_query = "select * from video";
connection.query(sql_query,function(error,rows,fields){
    if(!!error){
        console.log('Error at Updating server');
    }
    else {
        for(var i =0 ; i<count ; i++){
            Name[i]=rows[i].name;
            URL[i]=rows[i].address;
            console.log(Name[i] + URL[i]);
        }
    }
});

app.get('/',function(req,res){
    res.sendFile(__dirname +'/index.html')
});

server.listen(321);
console.log('Server Listing on 321 Port');


io.sockets.on('connection', function(socket){
        connections.push(socket);
        console.log('connected : %s sockets connected', connections.length);

        socket.on('disconnect',function(data){
            connections.splice(connections.indexOf(socket),1);
        console.log('Disconnected : %s sockets connected', connections.length);         
        });
        	if(!socket.naa){


            io.sockets.emit('naa',{
            Name_ : Name,
            URL_ : URL

        });
            socket.naa = true;
        }

        console.log(Name+URL);
});