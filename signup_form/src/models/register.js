const mongoose =require("mongoose");

const registerEmployeeSchema=new mongoose.Schema({
    firstname:{
        type:String,
        required:true
    },
    Last_name:{
        type:String,
        required:true
    },
    Email:{
        type:String,
        required:true,
        unique:true,
    },
    gender:{
        type:String,
        required:true
    },
    AadharNumber:{
        type:Number,
        required:true,
        unique:true,
    },
    PhoneNumber:{
        type:Number,
        required:true,
        unique:true,
    },
    Lawyer_License_number:{
        type:Number,
        required:true,
        unique:true,
    },
    Age:{
        type:Number,
        required:true
    },
    password:{
        type:String,
        required:true,
        unique:true,

    },
   confirmpassword:{
        type:String,
        required:true,

    },
    Address:{
        type:String,
        required:true,
    },

})
//now we need to create a collections
const Register =new mongoose.model("Register",registerEmployeeSchema);

module.exports = Register;