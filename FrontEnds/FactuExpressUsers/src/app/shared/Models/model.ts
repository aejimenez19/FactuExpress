export class usuario {
    id?:number;
    first_name?:String;
    last_name?:String;
    number_identification?:String;
    email?:any;
}


export class comercio {
    idCompany?:number;
    namecompany?:String;
    bills:bill[] = [];
}

export class bill {
   id?:number;
   typePayment?:String;
   referencesCode?:String;
   date?:String;
}


export class producto {
    id?:number;
    cantidad?:number;
    nombre?:String;
    total?:number;
    totaliva?:number;
    factura?:number;
}