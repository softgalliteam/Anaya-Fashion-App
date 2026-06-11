package com.learning.exp.view.fragments
import com.learning.exp.model.roomdb.CartDatabase


override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
) {

    super.onViewCreated(view, savedInstanceState)


    val database = CartDatabase.getDatabase(requireContext())


    binding.wishlistRecycler.layoutManager =
        GridLayoutManager(requireContext(),2)


    lifecycleScope.launch {


        val wishlist =
            database.wishlistDao().getWishlist()


        binding.wishlistRecycler.adapter =
            WishlistAdapter(wishlist)


    }

}