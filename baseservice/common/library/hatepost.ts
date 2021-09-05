import * as mongoose from 'mongoose';

const { Schema } = mongoose;

export const HatePost = mongoose.model('HatePost',
new Schema({
  description:  String,
  date: { type: Date, default: Date.now },
  paid: Boolean,
  amountPaid: {type: Number, default: 0.0},
  likes: Number,
  hashtags: [String]
}));