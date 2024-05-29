package scripts

/**
 *
 *   System              : alpha
 *   Sub-System          : alpha Configuration
 *   Version             : 1.0
 *   Copyright           : (c) GENESIS
 *   Date                : 2021-09-07
 *
 *   Function : Provide Data Server Configuration for alpha.
 *
 *   Modification History
 *
 */

dataServer {
    query("ALL_TRADES", TRADE)
    query("ALL_PRICES", TRADE){
        where{
          it.price > 10.0
        }
        fields{
            SYMBOL
            PRICE
        }
    }
}