import React from "react";
import styles from "./ShieldInfo.module.css";

import { ShieldProps } from "../../../../model/Shield";

type Props = {
    shieldProps: ShieldProps
}

const ShieldInfo: React.FC<Props> = ({shieldProps}) => {
    return(
        <div className={styles.painel_container} >
            <div className={styles.painel_actionTitle} >Shield:</div>
            <div>Status:</div>{shieldProps.powerStatus ? "On" : "Off"}
            <div>Capacity: {shieldProps.capacity}</div>
            <div>Consuming Power: {shieldProps.powerConsumption}</div>
        </div>
    );
}

export default ShieldInfo;
