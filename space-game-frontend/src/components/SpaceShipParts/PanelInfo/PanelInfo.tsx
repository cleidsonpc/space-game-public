import React from "react";
import styles from "./PanelInfo.module.css";

import PowerPlantInfo from "./PowerPlantInfo/PowerPlantInfo";
import { PowerPlantProps, PowerPlantInitialProps } from "../../../model/PowerPlant";

import EngineInfo from "./EngineInfo/EngineInfo";
import { EngineProps, EngineInitialProps } from "../../../model/Engine";

import ShieldInfo from "./ShieldInfo/ShieldInfo";
import { ShieldProps, ShieldInitialProps } from "../../../model/Shield";

type Props = {
    openPanelInfoDisplay:string
}

const PanelInfo: React.FC<Props> = ({openPanelInfoDisplay}) => {

    const [powerPlantProps, setPowerPlantProps] = React.useState<PowerPlantProps>( PowerPlantInitialProps );
    const [engineProps, setEngineProps] = React.useState<EngineProps>( EngineInitialProps );
    const [shieldProps, setShieldProps] = React.useState<ShieldProps>( ShieldInitialProps );

    const [infoPanel, setInfoPanel] = React.useState<any>();

    React.useEffect(() => {
        console.log(openPanelInfoDisplay);
        if(openPanelInfoDisplay === "powerPlantInfo") {
            setInfoPanel(<PowerPlantInfo powerPlantProps={powerPlantProps} />);
        } else if(openPanelInfoDisplay === "engineInfo") {
            setInfoPanel(<EngineInfo engineProps={engineProps} />);
        } else if(openPanelInfoDisplay === "shieldInfo") {
            setInfoPanel(<ShieldInfo shieldProps={shieldProps} />);
        } else {
            setInfoPanel(null);
        }
    }, [openPanelInfoDisplay]);

    return(
        <div className={styles.pi_container} >
            {infoPanel}
        </div>
    );
}

export default PanelInfo;
