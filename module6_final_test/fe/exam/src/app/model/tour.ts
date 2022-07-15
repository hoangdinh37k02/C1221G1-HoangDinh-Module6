import {LoaiTour} from "./loai-tour";
import {PhamVi} from "./pham-vi";

export interface Tour {
  maTour: number;
  tenTour: string;
  diaDiem: string;
  ngayKhoiHanh: string;
  ngayVe: string;
  ngayKTDK: string;
  soNguoiToiDa: string;
  lichTrinh: string;
  yeuCauDT: string;
  chiPhi: string;
  loaiTour: LoaiTour;
  phamVi: PhamVi;
}
