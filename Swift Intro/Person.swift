//
//  Person.swift
//  Exercise1
//
//  Created by Daniel on 8/24/14.
//  Copyright (c) 2014 Daniel. All rights reserved.
//

import Foundation

class Person {
    var age: Int
    var name: String
    
    func sumWithAge(years: Int) -> Int {
        return age + years
        
    }
    
    
    init(_name: String, _age: Int) {
        age = _age
        name = _name
        
    }
    
    func get_name() -> String {
        return name
    }
    
 


}