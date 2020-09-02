function AddOrSubDates(flag,d1,d2){
    
    var d1 = document.getElementById('d1').value;
    var d2 = document.getElementById('d2').value;

    var date1 = new Date(d1);
    var date2 = new Date(d2);
    if(flag==0){
        var diff = new Date(date2.getTime() - date1.getTime());
    }
    else{
        var diff = new Date(date2.getTime() + date1.getTime());
    }

    var x=(diff.getUTCFullYear());
    var y=(diff.getUTCMonth());
    var z=(diff.getUTCDate() - 1); 
    return ("DateOutput : "+y+"/"+z+"/"+x);

}

function DetermineDay() {

    var d1=document.getElementById('id3').value;
    var date1 = new Date(d1);
    days=['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday']
    
    alert("Day of the week is "+ days[date1.getDay()]);
                 
}

Date.prototype.getWeekNumber = function() { 
  
    var oneJan =  
        new Date(this.getFullYear(), 0, 1); 

    // calculating number of days  
    //in given year before given date 

    var numberOfDays =  
        Math.floor((this - oneJan) / (24 * 60 * 60 * 1000)); 

    // adding 1 since this.getDay() 
    //returns value starting from 0 

    return Math.ceil((this.getDay() + 1 + numberOfDays) / 7); 

} 

function GetWeekNumber(date1) { 

    var date1 = new Date(date1); 
    var result = date1.getWeekNumber(); 
    return ('Week number =' + result)
} 

module.exports.AddOrSubDates=AddOrSubDates
module.exports.DetermineDay=DetermineDay
module.exports.GetWeekNumber=GetWeekNumber