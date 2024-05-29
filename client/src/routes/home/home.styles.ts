import { css } from '@genesislcap/web-core';

export const HomeStyles = css`
  :host {
    /* insert css styles here */
  }
  .split-layout {
      display: flex;
      flex-direction: column;
      flex: 1;
      width: 100%;
      height: 100%;
  }

  .top-layout {
  height: 45%;
  flex-direction: row;
  }

  .positions-card {
  flex: 1;
  margin: calc(var(--design-unit) * 3px);
  }

  .card-title {
  padding: calc(var(--design-unit) * 3px);
  background-color: #22272a;
  font-size: 13px;
  font-weight: bold;
  }
`;
