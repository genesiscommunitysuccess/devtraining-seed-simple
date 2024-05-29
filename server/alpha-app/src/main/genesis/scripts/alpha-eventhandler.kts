import global.genesis.gen.dao.enums.alpha.trade.Direction
import global.genesis.gen.dao.enums.alpha.trade.TradeStatus
import java.time.LocalDate

/**
 * System              : Genesis Business Library
 * Sub-System          : multi-pro-code-test Configuration
 * Version             : 1.0
 * Copyright           : (c) Genesis
 * Date                : 2022-03-18
 * Function : Provide event handler config for multi-pro-code-test.
 *
 * Modification History
 */



eventHandler {

    stateMachine(TRADE.TRADE_STATUS){

        // EVENT_TRADE_INSERT
        insertEvent {
            initialStates(TradeStatus.NEW)

            onValidate{ trade ->
                require(LocalDate.of(trade.tradeDate!!.year, trade.tradeDate!!.monthOfYear, trade.tradeDate!!.dayOfMonth) >= LocalDate.of(now().year, now().monthOfYear, now().dayOfMonth))
            }
            onEvent { event ->
                event.withDetails {
                    enteredBy = event.userName
                }
            }
        }

        modifyEvent {
            mutableStates(TradeStatus.ALLOCATED, TradeStatus.CANCELLED)

            // EVENT_TRADE_ALLOCATED
            transitionEvent(TradeStatus.ALLOCATED){
                fromStates(TradeStatus.NEW)

                onValidate{ trade ->
                    require(LocalDate.of(trade.tradeDate!!.year, trade.tradeDate!!.monthOfYear, trade.tradeDate!!.dayOfMonth +2) >= LocalDate.of(now().year, now().monthOfYear, now().dayOfMonth))
                }

                onEvent{ event, trade ->
                    trade.enteredBy = event.userName
                }
            }

            // EVENT_TRADE_CANCELLED
            transitionEvent(TradeStatus.CANCELLED){
                fromStates(TradeStatus.NEW, TradeStatus.ALLOCATED)

                onValidate{ trade ->
                    require(trade.direction == Direction.BUY)
                    require(LocalDate.of(trade.tradeDate!!.year, trade.tradeDate!!.monthOfYear, trade.tradeDate!!.dayOfMonth + 1) >= LocalDate.of(now().year, now().monthOfYear, now().dayOfMonth))
                }

                onEvent{ event, trade ->
                    trade.enteredBy = event.userName
                    trade.tradeDate = now()
                    trade.tradeStatus = TradeStatus.CANCELLED
                }
            }
        }
    }

    eventHandler<Instrument>(name = "INSTRUMENT_MODIFY") {
        onCommit { event ->
            entityDb.modify(event.details)
            ack()
        }
    }

    eventHandler<Instrument>(name = "INSTRUMENT_DELETE") {
        onCommit { event ->
            entityDb.delete(event.details)
            ack()
        }
    }

    eventHandler<Instrument>(name = "INSTRUMENT_INSERT") {
        onCommit { event ->
            entityDb.insert(event.details)
            ack()
        }
    }

    eventHandler<Trade>(name = "TRADE_DELETE") {
        onCommit { event ->
            entityDb.delete(event.details)
            ack()
        }
    }

    eventHandler<Counterparty>(name = "COUNTERPARTY_MODIFY") {
        onCommit { event ->
            entityDb.modify(event.details)
            ack()
        }
    }

    eventHandler<Counterparty>(name = "COUNTERPARTY_DELETE") {
        onCommit { event ->
            entityDb.delete(event.details)
            ack()
        }
    }

    eventHandler<Counterparty>(name = "COUNTERPARTY_INSERT") {
        onCommit { event ->
            entityDb.insert(event.details)
            ack()
        }
    }

}