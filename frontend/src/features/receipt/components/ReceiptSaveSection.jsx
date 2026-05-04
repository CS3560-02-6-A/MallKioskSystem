// ReceiptSaveSection.jsx

// Receipt component: The qr code right area section
// Displays QR code for receipt and print receipt button.

import AppButton from "../../../components/ui/AppButton";
import qrCode from "../../../assets/images/qr-code.png";

export default function ReceiptSaveSection() {
  
  // Temporary but when you click print, you can now print yass.
  const handlePrint = () => {
    window.print();
  };

  return (
    <div className="receipt-actions no-print">
  
      {/* QR group */}
      <div className="qr-group">
        <img className="receipt-qr" src={qrCode} alt="QR Code" />
        <p className="or-text">Scan to save</p>
        
      </div>

      {/* OR divider */}
      <p className="or-text">OR</p>

      {/* Print button */}
      <AppButton onClick={handlePrint}>
        Print Receipt
      </AppButton>

    </div>
  );
}