import {html, ref, repeat} from '@microsoft/fast-element';
import type {Home} from './home';


export const HomeTemplate = html<Home>`
<zero-card style="height: 400px;">
  <zero-grid-pro>
   <grid-pro-genesis-datasource
          resource-name="ALL_TRADES" />
      <grid-pro-column :definition=${x => x.myActionsMenuColDef} />
  </zero-grid-pro>
</zero-card>
`;
