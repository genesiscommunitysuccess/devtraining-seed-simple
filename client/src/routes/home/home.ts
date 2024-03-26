import { customElement, FASTElement, observable} from '@microsoft/fast-element';
import { HomeTemplate as template } from './home.template';
import { HomeStyles as styles } from './home.styles';

@customElement({
  name,
  template,
  styles,
})
export class Home extends FASTElement {

}
