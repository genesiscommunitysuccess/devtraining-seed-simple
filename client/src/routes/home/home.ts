import { customElement, GenesisElement, observable} from '@genesislcap/web-core';
import { HomeStyles as styles } from './home.styles';
import { HomeTemplate as template } from './home.template';


@customElement({
  name: 'home-route',
  template,
  styles,
})


export class Home extends GenesisElement {

}
