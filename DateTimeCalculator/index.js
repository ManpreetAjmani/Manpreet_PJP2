const express = require('express');
const app = express();
const path = require('path');
const router = express.Router();

router.get('/',function(req,res){
  res.sendFile(path.join(__dirname+'/index.html'));
  //__dirname : It will resolve to your project folder.
});

router.get('/AddOrSub',function(req,res){
  res.sendFile(path.join(__dirname+'/AddOrSub.html'));
});

router.get('/day',function(req,res){
  res.sendFile(path.join(__dirname+'/day.html'));
});

router.get('/week',function(req,res){
    res.sendFile(path.join(__dirname+'/week.html'));
});

//add the router
app.use('/', router);
app.listen(3000);
console.log('Listening to port 3000');