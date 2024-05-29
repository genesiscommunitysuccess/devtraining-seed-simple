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
        field("COUNTERPARTY_ID",STRING).notNull()
        field("INSTRUMENT_ID",STRING).notNull()
        field("QUANTITY",INT)
        field("PRICE",DOUBLE).notNull()
        field("SYMBOL",STRING)
        field("DIRECTION", ENUM("BUY","SELL")).default("BUY")
    }

    table (name = "COUNTERPARTY", id = 2001) {
        field("COUNTERPARTY_ID",STRING).sequence("CP").primaryKey()
        field("COUNTERPARTY_NAME",STRING)
        field("ENABLED",BOOLEAN)
        field("COUNTERPARTY_LEI",STRING)
    }

    table (name = "INSTRUMENT", id = 2002) {
        field("INSTRUMENT_ID",STRING).sequence("IN").primaryKey()
        field("INSTRUMENT_NAME",STRING)
        field("MARKET_ID", STRING)
        field("COUNTRY_CODE",STRING)
        field("CURRENCY_ID",STRING)
        field("ASSET_CLASS", STRING)
    }
}