//
//  Factorial.swift
//  Exercise2
//
//  Created by Daniel on 9/10/14.
//  Copyright (c) 2014 Daniel. All rights reserved.
//

import Foundation

class Factorial {
    
    func calcRecursive(n: Int) -> Int {
        
        var result:Int = 1;
        if(n == 0)
        {
            return 1;
        }
        
        
        result = n * calcRecursive(n - 1);
        
        return result;
    }
    
    func calcInterative(n: Int) -> Int {
        
        var result:Int = 1;
        for (var i:Int = n; i > 0; i--) {
            result = result * i;
        }
        
        return result;
        
    }
    
}
