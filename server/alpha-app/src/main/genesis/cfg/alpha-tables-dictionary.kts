import global.genesis.dictionary.pal.table.TableFieldType

/**
 * System              : Genesis Business Library
 * Sub-System          : multi-pro-code-test Configuration
 * Version             : 1.0
 * Copyright           : (c) Genesis
 * Date                : 2022-03-18
 * Function : Provide table definition config for multi-pro-code-test.
 *
 * Modification History
 */

tables {
    table (name = "TRADE", id = 2000) {
        field("TRADE_ID",STRING).sequence("TR").primaryKey()
        field("QUANTITY",INT)
        field("PRICE",DOUBLE).notNull()
        field("SYMBOL",STRING)
        field("DIRECTION", ENUM("BUY","SELL")).default("BUY")
    }
}