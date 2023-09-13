package com.a406.horsebit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.a406.horsebit.databinding.FragmentHomeBinding
import com.a406.horsebit.databinding.FragmentStockOrderBinding

class StockOrderFragment : Fragment() {

    private lateinit var binding: FragmentStockOrderBinding

    val orderList = arrayListOf(
        Order(1343, 758, 0.03),
        Order(2723, 291, 0.07),
        Order(3091, 845, 0.18),
        Order(4558, 968, 0.27),
        Order(5300, 833, 0.41),
        Order(6115, 587, 0.53),
        Order(6787, 537, 0.62),
        Order(7539, 313, 0.76),
        Order(8975, 687, 0.89),
        Order(9901, 797, 0.97),
        Order(2092, 633, -0.98),
        Order(3894, 978, -0.92),
        Order(4640, 419, -0.81),
        Order(5774, 679, -0.75),
        Order(6309, 489, -0.68),
        Order(7372, 822, -0.65),
        Order(7915, 734, -0.52),
        Order(8399, 210, -0.49),
        Order(9106, 837, -0.47),
        Order(9997, 286, -0.42)
    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_stock_order, container, false)

        binding = FragmentStockOrderBinding.bind(view)

        binding.rvOrder.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvOrder.setHasFixedSize(true)

        binding.rvOrder.adapter = OrderItemAdapter(orderList)

        // 탭 헤더 색상 변경 시작
        binding.tvOrderBuyTabHeader.setTextColor(ContextCompat.getColor(binding.root.context, R.color.red))
        binding.tvOrderBuyTabHeader.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.white))
        binding.tvOrderSellTabHeader.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
        binding.tvOrderSellTabHeader.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.gray))
        binding.tvOrderTransactionHistoryTabHeader.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
        binding.tvOrderTransactionHistoryTabHeader.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.gray))
        // 텝 헤더 색상 변경 끝

        changFrag(0)

        binding.tvOrderBuyTabHeader.setOnClickListener {
            binding.tvOrderBuyTabHeader.setTextColor(ContextCompat.getColor(binding.root.context, R.color.red))
            binding.tvOrderBuyTabHeader.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.white))
            binding.tvOrderSellTabHeader.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
            binding.tvOrderSellTabHeader.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.gray))
            binding.tvOrderTransactionHistoryTabHeader.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
            binding.tvOrderTransactionHistoryTabHeader.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.gray))
            changFrag(0)
        }

        binding.tvOrderSellTabHeader.setOnClickListener {
            binding.tvOrderBuyTabHeader.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
            binding.tvOrderBuyTabHeader.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.gray))
            binding.tvOrderSellTabHeader.setTextColor(ContextCompat.getColor(binding.root.context, R.color.blue))
            binding.tvOrderSellTabHeader.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.white))
            binding.tvOrderTransactionHistoryTabHeader.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
            binding.tvOrderTransactionHistoryTabHeader.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.gray))
            changFrag(1)
        }

        binding.tvOrderTransactionHistoryTabHeader.setOnClickListener {
            binding.tvOrderBuyTabHeader.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
            binding.tvOrderBuyTabHeader.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.gray))
            binding.tvOrderSellTabHeader.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
            binding.tvOrderSellTabHeader.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.gray))
            binding.tvOrderTransactionHistoryTabHeader.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
            binding.tvOrderTransactionHistoryTabHeader.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.white))
            changFrag(2)
        }

        return view
    }

    private fun changFrag(fragNum: Int) {
        val ft = requireActivity().supportFragmentManager.beginTransaction()

        when(fragNum){
            0->{
                val changeFragment = OrderBuyTabFragment()

                ft.replace(R.id.fl_OrderTab, changeFragment)
                ft.commit()
            }
            1->{
                val changeFragment = OrderSellTabFragment()

                ft.replace(R.id.fl_OrderTab, changeFragment)
                ft.commit()
            }
            2->{
                val changeFragment = OrderTransactionHistoryTabFragment()

                ft.replace(R.id.fl_OrderTab, changeFragment)
                ft.commit()
            }
        }
    }
}