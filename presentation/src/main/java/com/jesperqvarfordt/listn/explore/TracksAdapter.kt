package com.jesperqvarfordt.listn.explore

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jesperqvarfordt.listn.R
import com.jesperqvarfordt.listn.common.extensions.msToTimeStamp
import com.jesperqvarfordt.listn.common.extensions.shuffleTo
import com.jesperqvarfordt.listn.domain.model.Track
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.item_track.view.*

class TracksAdapter
constructor(private val trackClicked: (tracks: List<Track>) -> Unit) :
        RecyclerView.Adapter<TracksAdapter.TrackViewHolder>() {

    private var tracks: MutableList<Track> = mutableListOf()

    fun updateTracks(newTracks: List<Track>) {
        tracks = newTracks.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return tracks.size
    }

    override fun onBindViewHolder(holder: TrackViewHolder?, position: Int) {
        holder?.onBind(tracks[position], position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TrackViewHolder {
        return TrackViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_track, parent, false))
    }

    inner class TrackViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun onBind(track: Track, pos: Int) {
            itemView.trackTitle.text = track.title
            itemView.trackDuration.text = track.durationInMs.msToTimeStamp()
            itemView.setOnClickListener({
                val temp = tracks.toMutableList()
                trackClicked.invoke(temp.shuffleTo(pos))
            })
            val transformation = RoundedCornersTransformation(4, 0)
            Picasso.with(itemView.context).load(track.thumbnailUrl).transform(transformation).into(itemView.coverImage)
        }

    }
}