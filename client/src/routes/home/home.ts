import { customElement, FASTElement } from '@microsoft/fast-element';
import { HomeStyles as styles } from './home.styles';
import { HomeTemplate as template } from './home.template';
import {DataGrid} from '@genesislcap/foundation-zero';
import { getActionsMenuDef, GridProRendererTypes } from '@genesislcap/grid-pro';



@customElement({
  name: 'home-route',
  template,
  styles,
})


export class Home extends FASTElement {


    customLogLevelCellRenderer = (params) => {
      return `<span style="color: green">Custom ${params.color}</span>`;
      }
      public myActionsMenuColDef = getActionsMenuDef(
        [
          {
            name: 'View',
            callback: rowData => console.log('VIEWW!!!', rowData),
          },
          {
            name: 'Delete',
            callback: rowData => console.log('DELETE!!!', rowData),
          },
        ],
        {
          headerName: 'Test Actions',
          width: 140,
          pinned: 'right'
        },
        '+',
      );

  public multipleCustomColumnConfigArray: ColDef[] = [
    {
      headerName: 'Is Active',
      field: 'IS_ACTIVE',
      pinned: "right"
    },
    {
      headerName: 'Custom ',
      width: 100,
      pinned: "right",
      cellRenderer: this.customLogLevelCellRenderer,
      cellRendererParams: {color: 'red'}
    }
  ];

public myCustomColumn: ColDef =[
  {
    headerName: 'Custom Name',
    pinned: 'right',
    cellRenderer: GridProRendererTypes.boolean,
    editable: true
  }]
;

}
