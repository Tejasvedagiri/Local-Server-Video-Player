var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var port = 4000;
var sql_query = ""
var mysql = require('mysql');
var connection = mysql.createConnection({
	host:'localhost',
	user: 'root',
	password: '',
	database: 'sampleDB'
});

connection.connect(function(error){
	if(!!error){
		console.log('error');
		}
	else {
		console.log('connected');
	}
});

app.get('/', function(req, res){
  res.sendFile(__dirname + '/index.html');
});

io.on('connection', function(socket){
  socket.on('chat message', function(msg){
    io.emit('chat message', msg);
  });
});

http.listen(port, function(){
  console.log('listening on *:' + port);
});
