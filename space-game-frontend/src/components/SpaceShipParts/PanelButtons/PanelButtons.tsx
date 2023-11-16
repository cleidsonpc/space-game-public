import React from "react";
import styles from "./PanelButtons.module.css";

import InputCheckbox from "../InputCheckbox/InputCheckbox";
import { EngineProps } from "../../../model/Engine";
import { PowerPlantProps } from "../../../model/PowerPlant";
import { ShieldProps } from "../../../model/Shield";

type Props = {
    engineProps: EngineProps,
    powerPlantProps: PowerPlantProps,
    shieldProps: ShieldProps
}

const PanelButtons: React.FC<Props> = ({engineProps, powerPlantProps, shieldProps}) => {

const powerPlantOnOff = (param:boolean) => {
        powerPlantProps.powerStatus = param;
        if(!param) {
            engineOnOff(false);
            shieldOnOff(false);
        }
//         if(param) {
//             powerPlantProps.energyAvailable = PowerPlantInitialProps.energyMax;
//         } else {
//             powerPlantProps.energyAvailable = 0;
//         }
//         setPowerPlantProps(powerPlantProps);
//         buildLogMessage("Power Plant is: " + (param ? "ON" : "OFF"));
    }

    const engineOnOff = (param:boolean) => {
        if(!powerPlantProps.powerStatus) {
            param = false;
        }
        engineProps.powerStatus = param;
//         setEngineProps(engineProps);
//         calcEngineEnergyAvailable();
//         buildLogMessage("Engine is: " + (param?"ON":"OFF"));
    }

    const shieldOnOff = (param:boolean) => {
        if(!powerPlantProps.powerStatus) {
            param = false;
        }
        if(param) {
            shieldProps.capacity = 100;
        } else {
            shieldProps.capacity = 0;
        }
        shieldProps.powerStatus = param;
//         setShieldProps(shieldProps);
//         calcEnergyAvailable();
//         buildLogMessage("Shield is: " + (param?"ON":"OFF"));


//         then((response) => response.json())
//               .then((data) => {
//                  setPosts((posts) => [data, ...posts]);
//                  setTitle('');
//                  setBody('');
//               })
//         if (response.status === 200) {
//             setPosts(
//                 posts.filter((post) => {
//                     return post.id !== id;
//                 })
//             );
//         } else {
//             return;
//         }
    }

    return(
        <div className={styles.power_button_container} >
            <div className={styles.power_button_leftContainer} >...</div>

            <div className={styles.power_button_rightContainer} >
                <div className={styles.power_button_switch} >
                    <InputCheckbox checked={powerPlantProps.powerStatus} onChange={powerPlantOnOff}/>
                </div>

                <div className={styles.power_button_switch} >
                    <InputCheckbox checked={engineProps.powerStatus} onChange={engineOnOff} />
                </div>

                <div className={styles.power_button_switch} >
                    <InputCheckbox checked={shieldProps.powerStatus} onChange={shieldOnOff} />
                </div>
            </div>
        </div>
    );
}

export default PanelButtons;
