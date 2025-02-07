import { useState } from "react";
import viteLogo from "/vite.svg";
import reactLogo from "../assets/react.svg";
import { FaFile } from "react-icons/fa";
import { AlgoTests } from "../Results";

const DataUpload: React.FC<{
    curStage: number;
    updateStage: React.Dispatch<React.SetStateAction<number>>;
    setJsonData: React.Dispatch<React.SetStateAction<AlgoTests[] | undefined>>;
}> = ({ curStage, updateStage, setJsonData }) => {
    const [valid, changeValidity] = useState(true);

    return (
        <>
            <div className="flex flex-col *:m-auto h-screen">
                <div className="flex flex-row">
                    <img src={viteLogo} className="w-32 inline  " />
                    <span className="text-8xl inline mx-10">+</span>
                    <img src={reactLogo} className="w-32 animate-spin inline" />
                </div>
                <div className="text-center">
                    <h1 className="m-10 text-3xl motion-preset-shake motion-loop-infinite">
                        Please select <FaFile className="inline" />
                        QuickSort.json (it should be under the Project1 folder)
                    </h1>
                    <input
                        onChange={async (e) => {
                            console.log("File uploaded");
                            let data: JSON | undefined = undefined;
                            if (e.target.files == null) {
                                changeValidity(false);
                                return;
                            }
                            console.log(
                                e.target.files[0].text().then((val) => val)
                            );
                            try {
                                data = JSON.parse(
                                    await e.target.files[0].text()
                                );
                                setJsonData(data as unknown as AlgoTests[]);
                                updateStage(curStage + 1);
                            } catch {
                                changeValidity(false);
                            }
                        }}
                        type="file"
                        accept=".json, .JSON"
                        className="file-input file-input-bordered w-full max-w-xs"
                    />
                    {valid ? null : (
                        <p className="text-red-500">Bad data submitted</p>
                    )}
                </div>
            </div>
        </>
    );
};
export default DataUpload;
