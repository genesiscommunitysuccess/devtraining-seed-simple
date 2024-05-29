import { customElement, GenesisElement, observable} from '@genesislcap/web-core';
import { HomeStyles as styles } from './home.styles';
import { HomeTemplate as template } from './home.template';
import {EntityManagement} from '@genesislcap/foundation-entity-management';

EntityManagement; //imported from '@genesislcap/foundation-entity-management' to display Trade grid


//describes the default config for the grid columns
const defaultColumnConfig = {
  enableCellChangeFlash: true,
  enableRowGroup: true,
  enablePivot: true,
  enableValue: true,
};

//grid columns that will be showed
const COLUMNS = [
  {
    ...defaultColumnConfig,
    field: 'TRADE_ID',
    headerName: 'Id',
  },
  {
    ...defaultColumnConfig,
    field: 'QUANTITY',
    headerName: 'Quantity',
  },
  {
    ...defaultColumnConfig,
    field: 'PRICE',
    headerName: 'Price',
  },
  {
    ...defaultColumnConfig,
    field: 'SYMBOL',
    headerName: 'Symbol',
  },
  {
    ...defaultColumnConfig,
    field: 'DIRECTION',
    headerName: 'Direction',
  },
];


@customElement({
  name: 'home-route',
  template,
  styles,
})


export class Home extends GenesisElement {
  @observable columns: any = COLUMNS;

  constructor() {
    super();
  }
}
