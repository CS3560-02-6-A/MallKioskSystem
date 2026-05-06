// ReceiptPage.jsx

import GoBackButton from "../../components/ui/GoBackButton";
import EndSessionButton from "../../components/ui/EndSessionButton";
import ReceiptCard from "./components/ReceiptCard";
import ReceiptSaveSection from "./components/ReceiptSaveSection";
import HeaderBar from "../../components/ui/HeaderBar";
import { mockOutfitItems } from "./mockData";
import { useNavigate, useLocation } from "react-router-dom";
import "../../styles/theme";
import "./ReceiptPage.css";


export default function ReceiptPage() {
  const location = useLocation();
  const outfitItems = location.state?.outfit ?? mockOutfitItems;

  return (
    <main className="receipt-page">

      {/* EDIT OUTFIT BUTTON (navigates back to builder) */}
      {/* Header (matches OutfitBuilderPage exactly) */}
      <div className="receipt-top no-print">
        <GoBackButton destination="/builder">
          ← Edit Outfit
        </GoBackButton>
      </div>

      {/* Header */}
      <section className="receipt-header">
        <h1>Lookin’ stylish!</h1>
        <p>Thank you for using Outfit Curator.</p>
      </section>

      {/* The main content: left = reciept, right = qr code area) */}
      <section className="receipt-content">
        <ReceiptCard items={outfitItems} />
        <ReceiptSaveSection />
      </section>

      {/* END SESSION BUTTON (navigates back to onboardinfg) */}
      <div className="receipt-bottom no-print">
        <EndSessionButton />
      </div>
    </main>
  );
}