import React from "react";
import styles from "./SpaceShipPage.module.css";

import PanelLogMessage from "../../components/SpaceShipParts/PanelLogMessage/PanelLogMessage";

import { PowerPlantProps, PowerPlantInitialProps } from "../../model/PowerPlant";
import { EngineProps, EngineInitialProps } from "../../model/Engine";
import { ShieldProps, ShieldInitialProps } from "../../model/Shield";
import PanelActions from "../../components/SpaceShipParts/PanelActions/PanelActions";
import PanelInfo from "../../components/SpaceShipParts/PanelInfo/PanelInfo";
import PanelButtons from "../../components/SpaceShipParts/PanelButtons/PanelButtons";

const SpaceShipPage: React.FC = () => {
    const [logMessage, setLogMessage] = React.useState<any>("");
    const [powerPlantProps, setPowerPlantProps] = React.useState<PowerPlantProps>( PowerPlantInitialProps );
    const [engineProps, setEngineProps] = React.useState<EngineProps>( EngineInitialProps );
    const [shieldProps, setShieldProps] = React.useState<ShieldProps>( ShieldInitialProps );

    const [openPanelInfoDisplay, setOpenPanelInfoDisplay] = React.useState<string>("");

    const buildLogMessage = async (param:string) => {
        setLogMessage(logMessage + " | " + param);
    }

    const fetchShipStatus = async () => {
        await fetch('http://localhost:8080/ship_status')
            .then((response) => response.json())
            .then((data) => {
                setShieldProps(data.shieldDto);
                setEngineProps(data.engineDto);
                setPowerPlantProps(data.powerPlantDto);
            }).catch((err) => {
                console.log(err.message);
            });
    };

    React.useEffect(() => {
        const interval = setInterval(() => {
          fetchShipStatus();
        }, 1000);

        return () => clearInterval(interval);
    }, []);

//         then((response) => response.json())
//               .then((data) => {
//                  setPosts((posts) => [data, ...posts]);
//                  setTitle('');
//                  setBody('');
//               })

//         if (response.status === 200) {
//           setPosts(
//              posts.filter((post) => {
//                 return post.id !== id;
//              })
//           );
//        } else {
//           return;
//        }


    const calcEngineEnergyAvailable = () => {
        if(engineProps.powerStatus) {
            powerPlantProps.energyAvailable -= engineProps.powerConsumption;
        } else if(powerPlantProps.powerStatus && !engineProps.powerStatus) {
            powerPlantProps.energyAvailable += engineProps.powerConsumption;
        }
        setPowerPlantProps(powerPlantProps);
    }

    const calcEnergyAvailable = () => {
        if(shieldProps.powerStatus) {
            powerPlantProps.energyAvailable -= shieldProps.powerConsumption;
        } else if(powerPlantProps.powerStatus && !shieldProps.powerStatus) {
            powerPlantProps.energyAvailable += shieldProps.powerConsumption;
        }
        setPowerPlantProps(powerPlantProps);
    }

    const backgroundEngineOnOff = () => {
        let result;

        if(engineProps.powerStatus) {
            result = styles.sp_backgroundEngineOn;
        } else {
            result = styles.sp_backgroundEngineOff;
        }

        return result;
    }

    return(
        <div className={styles.sp_container}>
            <div className={styles.sp_pageTitle} >Title</div>

            <div className={styles.sp_background + " " + backgroundEngineOnOff()} >
                <div className={styles.sp_shipPanelContainer} >
                    { engineProps.powerStatus ? "engine ON" : "" }

                    <div className={styles.sp_shipPanel} >
                        <div className={styles.sp_shipPainelLeft} >
                            <PanelActions
                                setInfoDisplay={setOpenPanelInfoDisplay}
                                powerPlantProps={powerPlantProps}
                                engineProps={engineProps}
                                shieldProps={shieldProps}
                            />
                        </div>

                        <div className={styles.sp_shipPainelMiddle} >
                            <PanelInfo openPanelInfoDisplay={openPanelInfoDisplay}/>
                        </div>

                        <div className={styles.sp_shipPainelRight} >
                            <div className={styles.sp_shipPainelRightUp} >
                                <PanelLogMessage message={logMessage} />
                            </div>

                            <div className={styles.sp_shipPainelRightDown} >
                                <PanelButtons
                                    powerPlantProps={powerPlantProps}
                                    engineProps={engineProps}
                                    shieldProps={shieldProps} />
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <div className={styles.sp_pageFooter} >
                Footer
            </div>
        </div>
    );
};

export default SpaceShipPage;
