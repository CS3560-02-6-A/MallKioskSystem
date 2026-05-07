import GoBackButton from "../../components/ui/GoBackButton";
import EndSessionButton from "../../components/ui/EndSessionButton";
import ReceiptCard from "./components/ReceiptCard";
import ReceiptSaveSection from "./components/ReceiptSaveSection";
import { mockOutfitItems } from "./mockData";
import { useLocation } from "react-router-dom";
import "./ReceiptPage.css";

export default function ReceiptPage() {
  const location = useLocation();

  console.log("ReceiptPage rendered");
  console.log("location state:", location.state);

  const outfitItems = location.state?.outfit
    ? Object.values(location.state.outfit)
    : mockOutfitItems;

  return (
    <main className="receipt-page">
      <div className="receipt-top no-print">
        <GoBackButton destination="/builder">
          ← Edit Outfit
        </GoBackButton>
      </div>

      <section className="receipt-header">
        <h1>Lookin’ stylish!</h1>
        <p>Thank you for using Outfit Curator.</p>
      </section>

      <section className="receipt-content">
        <ReceiptCard items={outfitItems} />
        <ReceiptSaveSection />
      </section>

      <div className="receipt-bottom no-print">
        <EndSessionButton />
      </div>
    </main>
  );
}